package ru.job4j.tracker;

public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String ID = "4";
    private static final String NAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            switch (answer) {
                case ADD:
                    this.createItem();
                    break;
                case SHOW:
                    this.showItems();
                    break;
                case EDIT:
                    this.editItem();
                    break;
                case DELETE:
                    this.deleteItem();
                    break;
                case ID:
                    this.findItemById();
                    break;
                case NAME:
                    this.findItemsByName();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    break;
            }
        }

    }

    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all Items");
        System.out.println("2. Edit Item");
        System.out.println("3. Delete Item");
        System.out.println("4. Find Item by id");
        System.out.println("5. Find Items by name");
        System.out.println("6. Exit program");
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки:");
        String desc = this.input.ask("Введите описание заявки:");
        long currentTime = System.currentTimeMillis();
        Item item = new Item(name, desc, currentTime);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId: " + item.getId() + "-----------");
    }

    private void showItems() {
        System.out.println("------------ Все заявки --------------");
        Item[] items = this.tracker.findAll();
        for (Item item : items) {
            System.out.print("Name: " + item.getName());
            System.out.print("  Description : " + item.getDesc());
            System.out.println("  Create Time : " + item.getTime());
        }
    }

    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id редактируемой заявки: ");
        String name = this.input.ask("Введите новое имя:");
        String desc = this.input.ask("Введите новое описание:");
        long currentTime = System.currentTimeMillis();
        Item item = new Item(name, desc, currentTime);
        boolean result = this.tracker.replace(id, item);
        if (result) {
            System.out.println(String.format("------------ Заявка редактирована -----------", id));
        } else {
            System.out.println("Не удалось редактировать заявку. Проверьте id.");
        }
    }

    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки: ");
        boolean result = this.tracker.delete(id);
        if (result) {
            System.out.println(String.format("------------ Заявка удалена -----------", id));
        } else {
            System.out.println("Не удалось удалить заявку. Проверьте id.");
        }
    }

    private void findItemById() {
        System.out.println("------------ Поиск заявки по id --------------");
    String id = this.input.ask("Введите id заявки: ");
    Item item = this.tracker.findById(id);
        if (item != null) {
        System.out.print("Name: " + item.getName());
        System.out.print("  Description : " + item.getDesc());
        System.out.println("  Create Time : " + item.getTime());
    } else {
        System.out.println("Заявка не найдена. Проверьте id.");
    }
}

    private void findItemsByName() {
        System.out.println("------------ Поиск заявок по имени --------------");
        String n = this.input.ask("Введите имя заявки: ");
        Item[] items = this.tracker.findByName(n);
        for (Item item : items) {
            System.out.print("Name: " + item.getName());
            System.out.print("  Description: " + item.getDesc());
            System.out.println("  Create Time: " + item.getTime());
        }
    }
}
