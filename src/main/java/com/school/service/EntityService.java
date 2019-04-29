package com.school.service;

import java.util.Optional;

public interface EntityService<Entity> {
Iterable<Entity> getAllItems();
	
	 void addItem(Entity fm);
	
	 void updateItem(Entity fm);
	
	 Optional<Entity> getItemById(int id);
	
	 Entity findAllById(Iterable<Integer> ids);
	//public item getItemByName(String itemName);
	
	 void removeItem(int id);
	
	 void removeItemByName(Entity bio);
	
	 void removeAllItems();
}
