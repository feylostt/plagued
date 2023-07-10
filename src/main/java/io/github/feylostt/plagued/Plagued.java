package io.github.feylostt.plagued;

import io.github.feylostt.plagued.items.PlaguedItems;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Plagued implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Plagued");
	public static final String MODID = "plagued";

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());

		// initializations
		PlaguedItems.init();
	}
}
