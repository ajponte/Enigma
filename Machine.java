
package enigma;

/** Class that represents a complete enigma machine.
 *  @author Alan Ponte
 */
class Machine {

    /** List of Rotors, 0,1...3; Ordered left to Right. */
    private Rotor[] myRotors = new Rotor[4];

    /** Set my rotors to (from left to right) ROTORS.  Initially, the rotor
     *  settings are all 'A'. */
    void replaceRotors(Rotor[] rotors) {
        for (int i = 0; i < rotors.length; i++) {
            myRotors[i] = rotors[i];
        }

    }
    /** Returns MYROTORS. */
    private Rotor[] getRotors() {
        return myRotors;
    }

    /** Set my rotors according to SETTING, which must be a string of four
     *  upper-case letters. The first letter refers to the leftmost
     *  rotor setting.  */
    void setRotors(String setting) {
        if (setting.length() != 4) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            myRotors[i].set(setting.charAt(i) - 'A');
        }
    }

    /** Returns the encoding/decoding of MSG, updating the state of
     *  the rotors accordingly. */
    String convert(String msg) {
        char[] answer = new char[msg.length()];
        for (int i = 0; i < msg.length(); i++) {
            boolean[] toRotate = new boolean[4];
            toRotate[3] = true;
            if (myRotors[3].atNotch()) {
                toRotate[2] = true;
            }
            if (myRotors[2].atNotch()) {
                toRotate[2] = true;
                toRotate[1] = true;
            }
            for (int j = 0; j < 4; j++) {
                if (toRotate[j]) {
                    myRotors[j].advance();
                }
            }
            int result = myRotors[3].convertForward(msg.charAt(i) - 'A');
            result = myRotors[2].convertForward(result);
            result = myRotors[1].convertForward(result);
            result = myRotors[0].convertForward(result);
            result = myRotors[1].convertBackward(result);
            result = myRotors[2].convertBackward(result);
            result = myRotors[3].convertBackward(result);
            answer[i] = (char) (result + 'A');
        }
        return new String(answer);
    }
}
