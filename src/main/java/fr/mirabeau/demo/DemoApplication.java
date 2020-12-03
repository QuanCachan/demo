package fr.mirabeau.demo;

import fr.mirabeau.demo.entity.Zone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		/*try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
			Inventory inventory = new Inventory();
			inventory.setName("EntrepoteTest");

			session.store(inventory);
			session.saveChanges();

			Zone zone1 = new Zone();
			zone1.setName("Zone1");
			zone1.setInventoryId(inventory.getId());

			Zone zone2= new Zone();
			zone2.setName("Zone2");
			zone2.setInventoryId(inventory.getId());

			List<Zone> zones = new ArrayList<Zone>();
			zones.add(zone1);
			zones.add(zone2);

			session.store(zone1);
			session.store(zone2);
			session.saveChanges();// Assign an 'Id' and collection (Inventories)
			// and start tracking an entity
		}catch (Exception e){
			System.out.println("###e ==> " +e.getMessage());
		}*/
		SpringApplication.run(DemoApplication.class, args);
	}
}
