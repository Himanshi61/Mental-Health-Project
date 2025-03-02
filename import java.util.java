import java.util.Scanner;

public class MentalHealthProject {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to the Mental Health Help Project");
            System.out.println("Please select a topic to learn more:");
            System.out.println("1. Depression");
            System.out.println("2. Anxiety");
            System.out.println("3. Gambling Addiction");
            System.out.println("4. Mania");
            System.out.println("5. PTSD");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayDepressionInfo();
                    break;
                case 2:
                    displayAnxietyInfo();
                    break;
                case 3:
                    displayGamblingInfo();
                    break;
                case 4:
                    displayManiaInfo();
                    break;
                case 5:
                    displayPTSDInfo();
                    break;
                case 6:
                    System.out.println("Thank you for using the Mental Health Help Project. Take care!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    public static void displayDepressionInfo() {
        System.out.println("\n--- Depression ---");
        System.out.println("Depression is a common mental health disorder characterized by persistent sadness and loss of interest.");
        System.out.println("Symptoms may include feelings of hopelessness, fatigue, and difficulty concentrating.");
        System.out.println("Treatment options include therapy, medication, and lifestyle changes.\n");
    }

    public static void displayAnxietyInfo() {
        System.out.println("\n--- Anxiety ---");
        System.out.println("Anxiety is a feeling of worry, nervousness, or unease about something with an uncertain outcome.");
        System.out.println("Symptoms may include restlessness, increased heart rate, and difficulty sleeping.");
        System.out.println("Treatment options include cognitive-behavioral therapy (CBT), medication, and relaxation techniques.\n");
    }

    public static void displayGamblingInfo() {
        System.out.println("\n--- Gambling Addiction ---");
        System.out.println("Gambling addiction is a type of impulse-control disorder where a person cannot resist the urge to gamble.");
        System.out.println("Symptoms may include chasing losses, lying about gambling, and financial problems.");
        System.out.println("Treatment options include therapy, support groups, and self-exclusion programs.\n");
    }

    public static void displayManiaInfo() {
        System.out.println("\n--- Mania ---");
        System.out.println("Mania is a state of abnormally elevated arousal, affect, and energy level.");
        System.out.println("Symptoms may include excessive happiness, irritability, and risky behavior.");
        System.out.println("Treatment options include mood stabilizers, antipsychotics, and therapy.\n");
    }

    public static void displayPTSDInfo() {
        System.out.println("\n--- PTSD (Post-Traumatic Stress Disorder) ---");
        System.out.println("PTSD is a mental health condition triggered by experiencing or witnessing a traumatic event.");
        System.out.println("Symptoms may include flashbacks, nightmares, and severe anxiety.");
        System.out.println("Treatment options include therapy (such as EMDR), medication, and support groups.\n");
    }
}