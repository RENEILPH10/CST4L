import java.util.*;

public class CstAct2 {
    //table for the NFA
    private static final Map<String, Map<Character, Set<String>>> table = new HashMap<>();

    //start state
    private static final String S_State = "q0";
    //Final state
    private static final Set<String> F_State = Set.of("q2");

    static {
        // tables
        table.put("q0", Map.of(
                'a', Set.of("q0", "q1"),
                'b', Set.of("q0")
        ));
        table.put("q1", Map.of(
                'b', Set.of("q2")
        ));
        table.put("q2", Map.of(
                'a', Set.of("q2"),
                'b', Set.of("q2")
        ));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter a string (a/b): ");
            String input = scanner.nextLine();

            Set<String> C_States = new HashSet<>();
            C_States.add(S_State);

            for (char symbol : input.toCharArray()) {
                Set<String> N_States = new HashSet<>();

                for (String state : C_States) {
                    Map<Character, Set<String>> stateTransitions = table.get(state);
                    if (stateTransitions != null && stateTransitions.containsKey(symbol)) {
                        N_States.addAll(stateTransitions.get(symbol));
                    }
                }

                System.out.println("Read: " + symbol + " → New states: " + N_States);
                C_States = N_States;
            }

            // Checker
            boolean accepted = C_States.stream().anyMatch(F_State::contains);

            if (accepted)
                System.out.println("Accepted yeyeyey");
            else
                System.out.println("Rejected, arayy koo");

            System.out.print("\nPress 1 to try again, or any key to exit: ");
            String choice = scanner.nextLine();
            if (!choice.equals("1")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
