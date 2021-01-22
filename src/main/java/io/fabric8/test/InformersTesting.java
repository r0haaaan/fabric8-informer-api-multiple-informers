package io.fabric8.test;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.api.model.rbac.RoleBinding;
import io.fabric8.kubernetes.api.model.rbac.RoleBindingList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class InformersTesting {
    public static final Logger logger = LoggerFactory.getLogger(InformersTesting.class);

    private static final long RESYNC_PERIOD = 20 * 60 * 1000L; // 20 minutes

    private static final CountDownLatch stopLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        try (final KubernetesClient k8s = new DefaultKubernetesClient()) {
            SharedInformerFactory informerFactory = k8s.informers();
            createConfigMapInformer(informerFactory);
            createSecretInformer(informerFactory);
            createRoleBindingInformer(informerFactory);

            informerFactory.addSharedInformerEventListener(e -> {
                stopLatch.countDown();
                logger.error("Exception encountered: ", e);
            });
            informerFactory.startAllRegisteredInformers();
            stopLatch.await();
            informerFactory.stopAllRegisteredInformers();
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            interruptedException.printStackTrace();
        }
    }

    private static void createConfigMapInformer(SharedInformerFactory informerFactory) {
        SharedIndexInformer<ConfigMap> configMapSharedIndexInformer = informerFactory.sharedIndexInformerFor(ConfigMap.class, ConfigMapList.class, RESYNC_PERIOD);
        configMapSharedIndexInformer.addEventHandler(new GenericResourceEventHandler<>("ConfigMap", logger));
    }

    private static void createSecretInformer(SharedInformerFactory informerFactory) {
        SharedIndexInformer<Secret> configMapSharedIndexInformer = informerFactory.sharedIndexInformerFor(Secret.class, SecretList.class, RESYNC_PERIOD);
        configMapSharedIndexInformer.addEventHandler(new GenericResourceEventHandler<>("Secret", logger));
    }

    private static void createRoleBindingInformer(SharedInformerFactory informerFactory) {
        SharedIndexInformer<RoleBinding> configMapSharedIndexInformer = informerFactory.sharedIndexInformerFor(RoleBinding.class, RoleBindingList.class, RESYNC_PERIOD);
        configMapSharedIndexInformer.addEventHandler(new GenericResourceEventHandler<>("RoleBinding", logger));
    }
}
