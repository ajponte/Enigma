
package enigma;

/** Class that represents a reflector in the enigma.
 *  @author Alan Ponte
 */
class Reflector extends Rotor {


	/** Returns a Reflector with CODENAME and POS */
	public Reflector (int codeName, int pos) {
		return super(codeName, pos);
	}
	
    @Override
    boolean hasInverse() {
        return false;
    }

    /** Returns a useless value; should never be called. */
    @Override
    int convertBackward(int unused) {
        throw new UnsupportedOperationException();
    }

}
