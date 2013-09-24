package enigma;

/** Class that represents a rotor that has no ratchet and does not advance.
 *  @author Alan Ponte
 */
class FixedRotor extends Rotor {


	public String _setting;
	public String codeName;
	
	/** Default constructor */
	public FixedRotor () {
		return FixedRotor(_setting, codeName);
	}
	/** Returns a Fixed Rotor with CODENAME and POS */
	public FixedRotor (codeName, pos) {
		return FixedRotor(codeName, pos);
		
	}
	
    @Override
    boolean advances() {
        return false;
    }

    @Override
    boolean atNotch() {
        return false;
    }

    /** Fixed rotors do not advance. */
    @Override
    void advance() {
    }

}
