package zaeonninezero.grenadesadozen.common;

import zaeonninezero.grenadesadozen.GrenadesADozen;
import zaeonninezero.grenadesadozen.pack.ModFilePackResources;

import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.forgespi.language.IModFileInfo;
import net.minecraftforge.forgespi.locating.IModFile;

@EventBusSubscriber
public class BuiltInResourcePackLoader {

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
	public static class ModBusEvents {

		@SubscribeEvent
		public static void addPackFinders(AddPackFindersEvent event) {
			// Pack finder code ported from Create 0.5.1
			if (event.getPackType() == PackType.CLIENT_RESOURCES) {
				IModFileInfo modFileInfo = ModList.get().getModFileById(GrenadesADozen.MOD_ID);
				if (modFileInfo == null) {
					//GrenadesADozen.LOGGER.error("Could not find Create mod file info; built-in resource packs will be missing!");
					return;
				}
				IModFile modFile = modFileInfo.getFile();
				event.addRepositorySource((consumer, constructor) -> {
					consumer.accept(Pack.create(GrenadesADozen.asResource("an0m3l1_grenades").toString(), false, () -> new ModFilePackResources("An0m3L1's Grenades", modFile, "resourcepacks/an0m3l1_grenades"), constructor, Pack.Position.TOP, PackSource.DEFAULT));
				});
				
			}
		}
	}
}
