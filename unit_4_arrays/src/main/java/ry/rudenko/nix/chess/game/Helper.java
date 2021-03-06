package ry.rudenko.nix.chess.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Helper {
    private static String shell = "defHelper";

    public void setShell(String shell) {
        this.shell = shell;
    }

    public String getShell() {
        return shell;
    }

    public Helper() {

    }

    public final void clearConsole() {

        int count = 0;
        Process process;

        if (!(shell.equals("shell"))) {
            for (int i = 0; i < 30; i++) {
                System.out.println();
            }
        } else {
            try {
                process = Runtime.getRuntime().exec("clear");
                StringBuilder output = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (count == 3) {
                        output.append(line + "\n");
                    }
                    output.append(line + "\n");
                }
                int exitVal = process.waitFor();
                if (exitVal == 0) {
                    System.out.println(output);
                } else {
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
