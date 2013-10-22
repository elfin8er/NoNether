package com.elfin8er.nonether;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener{
	
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	
	@EventHandler
	public static void onPortalTravel(PlayerPortalEvent event){ // This event is called when a player travels through a portal.
		Player player = event.getPlayer(); // Makes a new player type variable and sets it to the teleporting player.
	    if(event.getCause() == PlayerPortalEvent.TeleportCause.END_PORTAL){ // Checks if the portal is an end portal
	    	if(!player.hasPermission("noend.override")){ // If the player does NOT have the permission "noend.override"
	    		event.setCancelled(true); // Cancels the portal teleportation event
	    	}
	    }
	    if(event.getCause() == PlayerPortalEvent.TeleportCause.NETHER_PORTAL){ // Checks if the portal is a nether portal
	    	if(!player.hasPermission("nonether.override")){ // Checks if the player does NOT have the permission "nonether.override"
	    		event.setCancelled(true); // Cancels the portal teleportion event
	    	}
	    }
	}
}