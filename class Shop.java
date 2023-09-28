class Shop {
    private List<Toy> toys;

    public Shop() {
        toys = new ArrayList<Toy>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void removeToy(Toy toy) {
        toys.remove(toy);
    }

    public void sellToy(Toy toy) {
        for (Toy t : toys) {
            if (t.getName().equals(toy.getName()) && t.getAgeCategory().equals(toy.getAgeCategory())) {
                int quantity = t.getQuantity();
                if (quantity > 0) {
                    t.setQuantity(quantity - 1);
                    System.out.println("Sold: " + toy);
                } else {
                    System.out.println("Out of stock: " + toy);
                }
                break;
            }
        }
    }

    public void saveToFile(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (Toy toy : toys) {
            writer.write(toy.getName() + "," + toy.getAgeCategory() + "," + toy.getQuantity() + "\n");
        }
        writer.close();
    }

    public void readFromFile(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split(",");
            String name = parts[0];
            String ageCategory = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            Toy toy = new Toy(name, ageCategory, quantity);
            toys.add(toy);
        }
        bufferedReader.close();
    }

    public void printToys() {
        for (Toy toy : toys) {
            System.out.println(toy);
        }
    }
}
