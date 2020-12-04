package fr.mirabeau.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
		/*try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
			Product product1 = new Product();
			product1.setName("Methanol");
            product1.setReference("67-56-1");
            product1.setPhysicalState("liquid");
            product1.setUnit("litre");
            product1.setBookedQuantity("10");
            List<String> pictoGramList = new ArrayList<>();
            pictoGramList.add(SecurityPictogram.FLAMMABLE.name());
            pictoGramList.add(SecurityPictogram.TOXIC.name());
            pictoGramList.add(SecurityPictogram.HEALTH_HAZARD.name());
            product1.setSecurityPictogramList(pictoGramList);
            product1.setDescription("Highly flammable liquid and vapour\n" +
                    "Toxic if swallowed\n" +
                    "Causes damage to organs");
            product1.setComment("If medical advice is needed, have product container or label at hand\n" +
                    "Keep out of reach of children\n" +
                    "Read label before use");
            product1.setAttachment("security-files/Methanol");

            Product product2 = new Product();
            product2.setName("Lead metal sheet");
            product2.setReference("7439-92-1");
            product2.setPhysicalState("solid");
            product2.setUnit("gram");
            product2.setBookedQuantity("0");
            List<String> pictoGramList2 = new ArrayList<>();
            pictoGramList2.add(SecurityPictogram.IRRITANT.name());
            pictoGramList2.add(SecurityPictogram.HEALTH_HAZARD.name());
            pictoGramList2.add(SecurityPictogram.ENV_DAMAGE.name());
            product2.setSecurityPictogramList(pictoGramList2);
            product2.setDescription("Harmful if swallowed\n" +
                    "Harmful if inhaled\n" +
                    "May damage fertility of the unborn child");
            product2.setComment("If medical advice is needed, have product container or label at hand\n" +
                    "Keep out of reach of children\n" +
                    "Read label before use\n" +
                    "Wash skin thoroughly after handling");
            product2.setAttachment("security-files/Lead-metal-sheet");

            Product product3 = new Product();
            product3.setName("Oxygen");
            product3.setReference("231-956-9");
            product3.setPhysicalState("gas");
            product3.setUnit("litre");
            product3.setBookedQuantity("30");
            List<String> pictoGramList3 = new ArrayList<>();
            pictoGramList3.add(SecurityPictogram.OXIDIZING.name());
            pictoGramList3.add(SecurityPictogram.COMPRESSED_GAS.name());
            product3.setSecurityPictogramList(pictoGramList3);
            product3.setDescription("High pressure, oxidizing gas\n" +
                    "Vigorously accelerates combustion\n" +
                    "Keep oil, grease, and combustibles away");
            product3.setComment("Remove victim to uncontaminated area wearing self contained breathing apparatus.\n" +
                    "Keep victim warm and rested. Call a doctor." +
                    "Apply artificial respiration if breathing stopped.");
            product3.setAttachment("security-files/Oxygen");

			session.store(product1);
			session.store(product2);
			session.store(product3);
			session.saveChanges();
		}catch (Exception e){
			System.out.println("###e ==> " +e.getMessage());
		}*/
        SpringApplication.run(DemoApplication.class, args);
    }
}
