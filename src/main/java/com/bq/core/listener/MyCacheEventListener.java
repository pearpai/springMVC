package com.bq.core.listener;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by wuyunfeng on 16/9/23.
 */
public class MyCacheEventListener implements CacheEventListener {

    private Logger logger = LogManager.getLogger(MyCacheEventListener.class);

    public static final CacheEventListener INSTANCE = new MyCacheEventListener();

    @Override
    public void notifyElementRemoved(Ehcache cache, Element element)
            throws CacheException {
        logger.info("notifyElementRemoved:{} remove {}", cache.getName(),
                element.getObjectKey());

    }

    @Override
    public void notifyElementPut(Ehcache cache, Element element)
            throws CacheException {
        logger.info("notifyElementPut:{} put {} - {}", cache.getName(),
                element.getObjectKey(),element.getObjectValue());
    }

    @Override
    public void notifyElementUpdated(Ehcache cache, Element element)
            throws CacheException {
        logger.info("notifyElementUpdated:{} update {} - {}", cache.getName(),
                element.getObjectKey(),element.getObjectValue());

    }

    @Override
    public void notifyElementExpired(Ehcache cache, Element element) {
        logger.info("notifyElementExpired:{} expired {}", cache.getName(),
                element.getObjectKey());

    }

    @Override
    public void notifyElementEvicted(Ehcache cache, Element element) {
        logger.info("notifyElementEvicted:{} evicted {}", cache.getName(),
                element.getObjectKey());

    }

    @Override
    public void notifyRemoveAll(Ehcache cache) {
        logger.info("notifyRemoveAll:{} ", cache.getName());
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton instance");
    }

}