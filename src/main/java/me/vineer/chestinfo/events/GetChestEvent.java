package me.vineer.chestinfo.events;

import me.vineer.chestinfo.Chestinfo;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class GetChestEvent implements Listener {
    @EventHandler
    public void PlayerInteract(PlayerInteractEvent event) {
        if(!(event.getAction() == Action.RIGHT_CLICK_BLOCK))return;
        try {
            if(!Chestinfo.players.get(event.getPlayer().getName()))return;
        } catch (NullPointerException e) {
            return;
        }

        BlockState state =  event.getClickedBlock().getState();
        if(!(state instanceof Chest))return;
        Chest chest = (Chest) state;
        Inventory inventory = chest.getInventory();
        int slot = 0;
        String name = "";
        for(ItemStack item : inventory) {
            if(item != null) {
                if(!item.getItemMeta().hasDisplayName()) name = "default_name";
                else name = item.getItemMeta().getDisplayName();
                System.out.println("inventory.setItem(" + slot + ", GuiInventoryCreator.createGuiItem(Material." + item.getType() + ", " + "\"" + name + "\"" + fromLoreToString(item.getItemMeta().getLore()) + "));");
            }
            slot++;
            //inventory.setItem(8, GuiInventoryCreator.createGuiItem(Material.RED_STAINED_GLASS_PANE, ChatColor.RED + "Выбрать позже"));
        }
        System.out.println("");
    }

    private String fromLoreToString(List<String> lore) {
        if(lore == null) return "";
        String ans = "";
        for (int i = 0; i < lore.size(); i++) {
            ans += ", \"" + lore.get(i) + "\"";
        }
        return ans;
    }
}
