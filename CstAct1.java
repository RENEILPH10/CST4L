import java.util.*;

public class CstAct1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  table DFA
        Map<String, Map<Character, String>> table = new HashMap<>();
        table.put("q0", Map.of('0', "q1", '1', "q0"));
        table.put("q1", Map.of('0', "q1", '1', "q2"));
        table.put("q2", Map.of('0', "q1", '1', "q0"));

        // Start states
        String S_State = "q0";
        // Final State
        Set<String> F_States = Set.of("q2");

        while (true) {
            System.out.print("\nEnter a binary string (0/1): ");
            String input = scanner.nextLine();

            String C_State = S_State;


            for (char symbol : input.toCharArray()) {
                if (!table.get(C_State).containsKey(symbol)) {
                    System.out.println("Invalid symbol: " + symbol);
                    C_State = null;
                    break;
                }
                C_State = table.get(C_State).get(symbol);
                System.out.println("Read: " + symbol + " New State: " + C_State);
            }

            // Checker
            if (C_State != null && F_States.contains(C_State)) {
                System.out.println("Accepted! yeyeeeyey");
            } else if (C_State != null) {
                System.out.println("Rejected ka po? sakit no?");
            }

            // Try again?
            System.out.print("\nPress 1 to try again, or any other key to exit: ");
            String choice = scanner.nextLine();
            if (!choice.equals("1")) {
                System.out.println("Byeers!");
                break;
            }
            System.out.println("============================");
        }
    }
}
