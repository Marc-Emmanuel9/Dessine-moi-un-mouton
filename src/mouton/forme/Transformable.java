package mouton.forme;

public interface Transformable {

	public void homoth�tie(final int rapport);
	public void translation(final int dx, final int dy);
	abstract public void rotation();
	abstract public void sym�trieCentrale();
	abstract public void sym�trieAxiale();
}
