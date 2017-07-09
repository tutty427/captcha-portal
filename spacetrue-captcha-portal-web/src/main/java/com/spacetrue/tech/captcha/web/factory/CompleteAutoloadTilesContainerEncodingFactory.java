package com.spacetrue.tech.captcha.web.factory;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.evaluator.AttributeEvaluatorFactory;
import org.apache.tiles.extras.complete.CompleteAutoloadTilesContainerFactory;
import org.apache.tiles.freemarker.TilesSharedVariableFactory;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.freemarker.render.FreemarkerRenderer;
import org.apache.tiles.request.freemarker.render.FreemarkerRendererBuilder;
import org.apache.tiles.request.freemarker.servlet.SharedVariableLoaderFreemarkerServlet;
import org.apache.tiles.request.render.BasicRendererFactory;

/**
 * Created by Shaw on 2017/7/9.
 */
public class CompleteAutoloadTilesContainerEncodingFactory extends CompleteAutoloadTilesContainerFactory {

    private static final String FREEMARKER_RENDERER_NAME = "freemarker";

    @Override
    protected void registerAttributeRenderers(
            final BasicRendererFactory rendererFactory,
            final ApplicationContext applicationContext,
            final TilesContainer container,
            final AttributeEvaluatorFactory attributeEvaluatorFactory) {

        super.registerAttributeRenderers(rendererFactory, applicationContext, container, attributeEvaluatorFactory);

        FreemarkerRenderer freemarkerRenderer = FreemarkerRendererBuilder
                .createInstance()
                .setApplicationContext(applicationContext)
                .setParameter("TemplatePath", "/")
                .setParameter("NoCache", "true")
                .setParameter("ContentType", "text/html;charset=UTF-8")
                .setParameter("template_update_delay", "0")
                .setParameter("default_encoding", "UTF-8")
                .setParameter("number_format", "0.##########")
                .setParameter(SharedVariableLoaderFreemarkerServlet.CUSTOM_SHARED_VARIABLE_FACTORIES_INIT_PARAM,
                        "tiles," + TilesSharedVariableFactory.class.getName()).build();

        rendererFactory.registerRenderer(FREEMARKER_RENDERER_NAME, freemarkerRenderer);

    }
}
