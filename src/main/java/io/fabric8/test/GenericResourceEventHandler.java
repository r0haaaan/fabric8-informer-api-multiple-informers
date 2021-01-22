package io.fabric8.test;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import org.slf4j.Logger;

public class GenericResourceEventHandler<T extends HasMetadata> implements ResourceEventHandler<T> {
    private final String kind;
    private final Logger logger;

    public GenericResourceEventHandler(String kind, Logger logger) {
        this.kind = kind;
        this.logger = logger;
    }

    @Override
    public void onAdd(T t) {
        logger.info("ADD {} {}", kind, t.getMetadata().getName());
    }

    @Override
    public void onUpdate(T t, T t1) {
        logger.info("MODIFIED {} {}", kind, t.getMetadata().getName());
    }

    @Override
    public void onDelete(T t, boolean b) {
        logger.info("DELETED {} {}", kind, t.getMetadata().getName());
    }
}
