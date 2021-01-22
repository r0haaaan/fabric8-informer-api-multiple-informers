# Using Fabric8 Kubernetes Client Informer API for monitoring multiple resources

A simple demo project demonstrating using informers for multiple resources

## How to Build
You just need to issue this simple command:
```bash
mvn clean install
```

## How to Run
Once the build is finished, you can run the packaged jar:
```bash
fabric8-informer-api-multiple-informers : $ java -jar target/fabric8-informer-api-multiple-informers-1.0-SNAPSHOT-jar-with-dependencies.jar 
[main] DEBUG io.fabric8.kubernetes.client.Config - Trying to configure client from Kubernetes config...
[main] DEBUG io.fabric8.kubernetes.client.Config - Found for Kubernetes config at: [/home/rohaan/.kube/config].
[informer-controller-ConfigMap] INFO io.fabric8.kubernetes.client.informers.cache.Controller - informer#Controller: ready to run resync and reflector runnable
[informer-controller-Secret] INFO io.fabric8.kubernetes.client.informers.cache.Controller - informer#Controller: ready to run resync and reflector runnable
[informer-controller-RoleBinding] INFO io.fabric8.kubernetes.client.informers.cache.Controller - informer#Controller: ready to run resync and reflector runnable
[informer-controller-ConfigMap] INFO io.fabric8.kubernetes.client.informers.cache.Reflector - Started ReflectorRunnable watch for class io.fabric8.kubernetes.api.model.ConfigMap
[informer-controller-RoleBinding] INFO io.fabric8.kubernetes.client.informers.cache.Reflector - Started ReflectorRunnable watch for class io.fabric8.kubernetes.api.model.rbac.RoleBinding
[informer-controller-Secret] INFO io.fabric8.kubernetes.client.informers.cache.Reflector - Started ReflectorRunnable watch for class io.fabric8.kubernetes.api.model.Secret
[informer-controller-ConfigMap] DEBUG io.fabric8.kubernetes.client.informers.cache.Reflector - Listing items (7) for resource class io.fabric8.kubernetes.api.model.ConfigMap v30910
[informer-controller-RoleBinding] DEBUG io.fabric8.kubernetes.client.informers.cache.Reflector - Listing items (12) for resource class io.fabric8.kubernetes.api.model.rbac.RoleBinding v30910
[informer-controller-ConfigMap] DEBUG io.fabric8.kubernetes.client.informers.cache.Reflector - Starting watcher for resource class io.fabric8.kubernetes.api.model.ConfigMap v30910
[informer-controller-RoleBinding] DEBUG io.fabric8.kubernetes.client.informers.cache.Reflector - Starting watcher for resource class io.fabric8.kubernetes.api.model.rbac.RoleBinding v30910
[informer-controller-RoleBinding] DEBUG io.fabric8.kubernetes.client.dsl.internal.WatchConnectionManager - Connecting websocket to https://192.168.39.200:8443/apis/rbac.authorization.k8s.io/v1/rolebindings...
[informer-controller-ConfigMap] DEBUG io.fabric8.kubernetes.client.dsl.internal.WatchConnectionManager - Connecting websocket to https://192.168.39.200:8443/api/v1/configmaps...
[pool-4-thread-1] DEBUG io.fabric8.kubernetes.client.informers.cache.Reflector - Listing items (7) for resource class io.fabric8.kubernetes.api.model.ConfigMap v30910
[informer-controller-Secret] DEBUG io.fabric8.kubernetes.client.informers.cache.Reflector - Listing items (36) for resource class io.fabric8.kubernetes.api.model.Secret v30910
[informer-controller-Secret] DEBUG io.fabric8.kubernetes.client.informers.cache.Reflector - Starting watcher for resource class io.fabric8.kubernetes.api.model.Secret v30910
[informer-controller-Secret] DEBUG io.fabric8.kubernetes.client.dsl.internal.WatchConnectionManager - Connecting websocket to https://192.168.39.200:8443/api/v1/secrets...
[OkHttp https://192.168.39.200:8443/...] DEBUG io.fabric8.kubernetes.client.dsl.internal.WatchConnectionManager - WebSocket successfully opened
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - ADD RoleBinding kubeadm:bootstrap-signer-clusterinfo
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - ADD RoleBinding system:controller:bootstrap-signer
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - ADD RoleBinding kube-proxy
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - ADD RoleBinding kubeadm:kubelet-config-1.19
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - ADD RoleBinding kubeadm:nodes-kubeadm-config
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - ADD RoleBinding system::extension-apiserver-authentication-reader
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - ADD RoleBinding system::leader-locking-kube-controller-manager
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - ADD RoleBinding system::leader-locking-kube-scheduler
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - ADD RoleBinding system:controller:bootstrap-signer
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - ADD RoleBinding system:controller:cloud-provider
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - ADD RoleBinding system:controller:token-cleaner
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - ADD RoleBinding system:persistent-volume-provisioner
[pool-12-thread-1] DEBUG io.fabric8.kubernetes.client.informers.cache.Reflector - Listing items (12) for resource class io.fabric8.kubernetes.api.model.rbac.RoleBinding v30910
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED RoleBinding kubeadm:bootstrap-signer-clusterinfo
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED RoleBinding system:controller:bootstrap-signer
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED RoleBinding kube-proxy
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED RoleBinding kubeadm:kubelet-config-1.19
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED RoleBinding kubeadm:nodes-kubeadm-config
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED RoleBinding system::extension-apiserver-authentication-reader
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED RoleBinding system::leader-locking-kube-controller-manager
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED RoleBinding system::leader-locking-kube-scheduler
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED RoleBinding system:controller:bootstrap-signer
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED RoleBinding system:controller:cloud-provider
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED RoleBinding system:controller:token-cleaner
[pool-9-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED RoleBinding system:persistent-volume-provisioner
[OkHttp https://192.168.39.200:8443/...] DEBUG io.fabric8.kubernetes.client.dsl.internal.WatchConnectionManager - WebSocket successfully opened
[pool-1-thread-1] INFO io.fabric8.test.InformersTesting - ADD ConfigMap game-demo
[pool-1-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED ConfigMap game-demo
[pool-1-thread-1] INFO io.fabric8.test.InformersTesting - ADD ConfigMap cluster-info
[pool-1-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED ConfigMap cluster-info
[pool-1-thread-1] INFO io.fabric8.test.InformersTesting - ADD ConfigMap coredns
[pool-1-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED ConfigMap coredns
[pool-1-thread-1] INFO io.fabric8.test.InformersTesting - ADD ConfigMap extension-apiserver-authentication
[pool-1-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED ConfigMap extension-apiserver-authentication
[pool-1-thread-1] INFO io.fabric8.test.InformersTesting - ADD ConfigMap kube-proxy
[pool-1-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED ConfigMap kube-proxy
[pool-1-thread-1] INFO io.fabric8.test.InformersTesting - ADD ConfigMap kubeadm-config
[pool-1-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED ConfigMap kubeadm-config
[pool-1-thread-1] INFO io.fabric8.test.InformersTesting - ADD ConfigMap kubelet-config-1.19
[pool-1-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED ConfigMap kubelet-config-1.19
[pool-8-thread-1] DEBUG io.fabric8.kubernetes.client.informers.cache.Reflector - Listing items (36) for resource class io.fabric8.kubernetes.api.model.Secret v30910
[OkHttp https://192.168.39.200:8443/...] DEBUG io.fabric8.kubernetes.client.dsl.internal.WatchConnectionManager - WebSocket successfully opened
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - ADD Secret default-token-59vdp
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED Secret default-token-59vdp
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - ADD Secret default-token-d9c56
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED Secret default-token-d9c56
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - ADD Secret default-token-htk5v
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED Secret default-token-htk5v
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - ADD Secret attachdetach-controller-token-2dtb5
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED Secret attachdetach-controller-token-2dtb5
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - ADD Secret bootstrap-signer-token-6c48l
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED Secret bootstrap-signer-token-6c48l
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - ADD Secret certificate-controller-token-z2ppf
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED Secret certificate-controller-token-z2ppf
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - ADD Secret clusterrole-aggregation-controller-token-tpxgm
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED Secret clusterrole-aggregation-controller-token-tpxgm
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - ADD Secret coredns-token-9ktxs
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - MODIFIED Secret coredns-token-9ktxs
[pool-5-thread-1] INFO io.fabric8.test.InformersTesting - ADD Secret cronjob-controller-token-26xgs

```
