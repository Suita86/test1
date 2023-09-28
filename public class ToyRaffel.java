public class ToyRaffle {
    public static void main(String[] args) throws IOException {
        Shop shop = new Shop();
        shop.readFromFile("toys.txt");
        System.out.println("TOYS:");
        shop.printToys();

        Raffle raffle = new Raffle(3);
        raffle.readFromFile("participants.txt");
        System.out.println("PARTICIPANTS:");
        for (String participant : raffle.getParticipants()) {
            System.out.println(participant);
        }

        raffle.drawWinners();
        raffle.saveToFile("winners.txt");
        raffle.printWinners();

        Toy toy = new Toy("Lego", "5-10 years", 1);
        shop.sellToy(toy);
        shop.saveToFile("toys.txt");
    }
}
