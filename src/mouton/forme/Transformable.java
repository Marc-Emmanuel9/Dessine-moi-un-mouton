package mouton.forme;

public interface Transformable {

	public void homothétie(final int rapport);
	public void translation(final int dx, final int dy);
	abstract public void rotation();
	abstract public void symétrieCentrale();
	abstract public void symétrieAxiale();
}
