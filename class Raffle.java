class Raffle {
    private List<String> participants;
    private int numberOfWinners;
    private List<String> winners;

    public Raffle(int numberOfWinners) {
        participants = new ArrayList<String>();
        this.numberOfWinners = numberOfWinners;
        winners = new ArrayList<String>();
    }

    public void addParticipant(String participant) {
        participants.add(participant);
    }

    public void drawWinners() {
        Random random = new Random();
        while (winners.size() < numberOfWinners && winners.size() < participants.size()) {
            int index = random.nextInt(participants.size());
            String winner = participants.get(index);
            if (!winners.contains(winner)) {
                winners.add(winner);
            }
        }
    }

    public void saveToFile(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (String participant : participants) {
            writer.write(participant + "\n");
        }
        writer.write("WINNERS:\n");
        for (String winner : winners) {
            writer.write(winner + "\n");
        }
        writer.close();
    }

    public void readFromFile(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("WINNERS:")) {
                break;
            }
            participants.add(line);
        }
        while ((line = bufferedReader.readLine()) != null) {
            winners.add(line);
        }
        bufferedReader.close();
    }

    public void printWinners() {
        System.out.println("WINNERS:");
        for (String winner : winners) {
            System.out.println(winner);
        }
    }
}