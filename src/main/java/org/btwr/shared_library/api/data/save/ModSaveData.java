package org.btwr.shared_library.api.data.save;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.world.PersistentState;

/** Abstract class for easier management of save data attached to the world **/
public abstract class ModSaveData extends PersistentState {
    /** Use to initialize any values for the saved data.
     * <p> Called after the server starts.
     * **/
    protected abstract void initialize(MinecraftServer server);

    /** Use to sync any saved data.
     * <p> Called after the player joins the server.
     * **/
    protected abstract void sync(ServerPlayNetworkHandler handler, PacketSender sender, MinecraftServer server);

    /**
     * Returns the saved data instance from the persistent state manager.
     *
     * <p>This can use the overworld or any other dimension, as all worlds on a
     * server share the same {@link net.minecraft.world.PersistentStateManager}.
     * <p>
     * {@snippet :
     * ServerWorld world = server.getWorld(ServerWorld.OVERWORLD);
     *
     * if (world == null) {
     *     return new ModSaveData();
     * }
     *
     * // The first time getOrCreate() is called, it creates a new instance of the
     * // data and stores it in the PersistentStateManager.
     * //
     * // On subsequent calls, the saved NBT is read from disk and decoded by the
     * // Codec defined by the supplied PersistentState.Type.
     * return world.getPersistentStateManager().getOrCreate(TYPE, "my_difficulty");
     *}
     *
     * @param server the Minecraft server instance
     * @return the loaded or newly created save data instance
     */
    static <T extends PersistentState> T get(MinecraftServer server) {
        return null;
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        return null;
    }
}
