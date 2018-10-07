package me.nand.npu.core;

public enum Platform {
	NintendoDS, NintendoWii, NintendoDSi, Nintendo3DS, NintendoWiiU, NintendoSwitch;
	
	public static Platform getPlatform(String platformName) {
	  switch(platformName.toLowerCase()) {
  	    case "ds":
  	      return NintendoDS;
	    case "wii":
	      return NintendoWii;
        case "dsi":
        case "ds i":
        case "ds-i":
        case "ds_i":
          return NintendoDSi;
        case "3ds":
          return Nintendo3DS;
	    case "wiiu":
	    case "wii u":
	    case "wii-u":
	    case "wii_u":
          return NintendoWiiU;
        case "switch":
          return NintendoSwitch;
        default:
          return null;
	  }
	}
}
