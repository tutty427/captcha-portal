package com.spacetrue.tech.captcha.web.factory;

import org.apache.tiles.factory.AbstractTilesContainerFactory;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.startup.AbstractTilesInitializer;
import org.springframework.stereotype.Component;

/**
 * Created by Shaw on 2017/7/9.
 */
@Component("encodingTilesInitializer")
public class CompleteAutoloadDefaultEncodingTilesInitializer extends AbstractTilesInitializer {

    /**
     * Creates a Tiles container factory. If you override this class, please
     * override this method or {@link #createContainer(ApplicationContext)}.
     *
     * @param context The servlet context to use.
     * @return The created container factory.
     * @since 2.2.0
     */
    @Override
    protected AbstractTilesContainerFactory createContainerFactory(ApplicationContext context) {
        return new CompleteAutoloadTilesContainerEncodingFactory();
    }
}
