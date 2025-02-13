package ex2;

import java.util.List;

public class Agenda extends Contact implements ContactsInterface {
    private ContactsStorageInterface list;
    private List<Contact> contacts;

    public Agenda(ContactsStorageInterface list) {
        super("", "", "");
        this.list = list;
        this.contacts = list.loadContacts();
    }

    @Override
    public void openAndLoad(ContactsStorageInterface list) {
        this.list = list;
        this.contacts = list.loadContacts();
    }

    @Override
    public void saveAndClose() {
        list.saveContacts(contacts);
    }

    @Override
    public void saveAndClose(ContactsStorageInterface list) {
        list.saveContacts(contacts);
    }

    @Override
    public boolean exist(Contact contact) {
        return contacts.contains(contact);
    }

    @Override
    public Contact getByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public boolean add(Contact contact) {
        if (contacts.contains(contact)) {
            return false;
        }
        contacts.add(contact);
        return true;
    }

    @Override
    public boolean remove(Contact contact) {
        return contacts.remove(contact);
    }
}
