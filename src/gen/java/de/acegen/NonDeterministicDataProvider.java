	/********************************************************************************
	 * generated by de.acegen 1.0.1
	 ********************************************************************************/
	
	
	
	
	package de.acegen;
	
	import java.util.concurrent.ConcurrentHashMap;
	import java.util.concurrent.ConcurrentMap;
	
	import java.time.LocalDateTime;
	
	public class NonDeterministicDataProvider {
		
		private static ConcurrentMap<String, LocalDateTime> systemTimeMap = new ConcurrentHashMap<>();

		private static ConcurrentMap<String, ConcurrentMap<String, Object>> valueMap = new ConcurrentHashMap<>();
	
		public static void putSystemTime(String uuid, LocalDateTime systemTime) {
			if (uuid != null && systemTime != null) {
				systemTimeMap.put(uuid, systemTime);
			}
		}
		
		public static void put(String uuid, String key, Object value) {
			if (uuid != null && value != null) {
				ConcurrentMap<String, Object> mapForUuid = valueMap.get(uuid);
				if (mapForUuid == null) {
					mapForUuid = new ConcurrentHashMap<String, Object>();
					valueMap.put(uuid, mapForUuid);
				}
				mapForUuid.put(key, value);
			}
		}
		
		public static LocalDateTime consumeSystemTime(String uuid) {
			if (uuid != null) {
				LocalDateTime value = systemTimeMap.get(uuid);
				if (value != null) {
					systemTimeMap.remove(uuid);
				}
				return value;
			} else {
				return null;
			}
		}
	
		public static Object consumeValue(String uuid, String key) {
			if (uuid != null && key != null) {
				ConcurrentMap<String, Object> mapForUuid = valueMap.get(uuid);
				if (mapForUuid == null) {
					return null;
				}
				Object value = mapForUuid.get(key);
				mapForUuid.remove(key);
				if (mapForUuid.size() == 0) {
					valueMap.remove(uuid);
				}
				return value;
			} else {
				return null;
			}
		}
		
	}

	
	
	/******* S.D.G. *******/
	
	
	
