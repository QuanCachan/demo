package fr.mirabeau.demo.service.internal.dao.impl.dbconnection;

import net.ravendb.client.documents.DocumentStore;

public class DocumentStoreHolder {
    private static DocumentStore store;

    private static DocumentStore createDocumentStore() {
        String serverURL = "http://localhost:9090";
        String databaseName = "InventoryDB";

        DocumentStore documentStore = new DocumentStore(new String[] { serverURL }, databaseName);

        documentStore.initialize();
        return documentStore;
    }

    public static DocumentStore getStore() {
        if (store == null) {
            store = createDocumentStore();
        }

        return store;
    }
}
