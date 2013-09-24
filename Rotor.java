
package enigma;

/** Class that represents a rotor in the enigma machine.
 *  @author Alan Ponte
 */
class Rotor {
    // This needs other methods, fields, and constructors.
    private boolean hasRatchet = false;
    private boolean canAdvance = false;
    private int codeName;
    private static String[] notchPositions = {
        "", "Q", "E", "V", "J", "Z", "ZM", "ZM", "ZM"
    };
    /** Size of alphabet used for plaintext and ciphertext. */
    static final int ALPHABET_SIZE = 26;


    static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /** Default rotor I with posion A */
    public Rotor() {
        this.codeName = 1;
        this.postion = 0;
    }
    /** Overloaded constructor to set CODENAME and POSITION. */
    public Rotor(int cn, int psn) {
        this.codeName = cn;
        this.position = psn;
    }
    /* Returns POSITION. */
    public int getPosition(){
        return position;
    }
    /* Returns CODENAME. */
    public int getCodeName(){
        return codeName;
    }
	/** Checks to see if an array of Strings, ARR has a third entry.  
	 *  Looks for ArrayIndexOutOfBoundsException to determine state  */
	private static boolean hasThirdEntry(String[] arr) {
		String third;
		boolean hasThirdEntry = true;
		try {
			third = arr[2];
		}
		catch (ArrayIndexOutOfBoundsException e){
			hasThirdEntry = false;
		}
		return hasThirdEntry;
		
	}
    /** Assuming that P is an integer in the range 0..25, returns the
     *  corresponding upper-case letter in the range A..Z. */
    static char toLetter(int p) {
        return LETTERS.charAt(p);
    }

    /** Assuming that C is an upper-case letter in the range A-Z, return the
     *  corresponding index in the range 0..25. Inverse of toLetter. */
    static int toIndex(char c) {
        return LETTERS.indexOf(c);
    }

    /** Returns true iff this rotor has a ratchet and can advance. */
    boolean advances() {
        return hasRatchet && canAdvance;
    }

    /** Returns true iff this rotor has a left-to-right inverse.
     *  The third entry of Permutation Data, if present, is the inverse of the
     *  second */
    boolean hasInverse() {

		return (hasThirdEntry(PermutationData.ROTOR_SPECS[_setting]))

    }

    /** Return my current rotational setting as an integer between 0
     *  and 25 (corresponding to letters 'A' to 'Z').  */
    int getSetting() {
        return _setting;
    }

    /** Set getSetting() to POSN.  */
    void set(int posn) {
        assert 0 <= posn && posn < ALPHABET_SIZE;
        _setting = posn;
    }

    /** Return the conversion of P (an integer in the range 0..25)
     *  according to my permutation. */
    int convertForward(int p) {
		String permutedCodeName = PermutationData.RotorSpecs[codeName];
        return (permutedCodeName.charAt((p + _setting) % ALPHABET_SIZE) 
            - _setting - 'A') %  ALPHABET_SIZE;
    }

    /** Return the conversion of E (an integer in the range 0..25)
     *  according to the inverse of my permutation. */
    int convertBackward(int e) {
        return ((PermutationData.RotorSpecs[codeName].charAt(e + position) 
            % ALPHABET_SIZE) - _setting - 'A') % ALPHABET_SIZE;
    }

    /** Returns true iff I am positioned to allow the rotor to my left
     *  to advance. */
    boolean atNotch() {
        if (codeName <= 5) {
            return notchPosition[codename].charAt(0)
                == (char) ('A' + position);
        } else {
            return ((char) ('A' + _setting)) == 'z';
                || ((char) ('A' + _setting)) == 'M';
        }
    }

    /** Advance me one position. */
    void advance() {
        this.position = (this.position + 1) % ALPHABET_SIZE;
    }

    /** My current setting (index 0..25, with 0 indicating that 'A'
     *  is showing). */
    private int _setting;

}
