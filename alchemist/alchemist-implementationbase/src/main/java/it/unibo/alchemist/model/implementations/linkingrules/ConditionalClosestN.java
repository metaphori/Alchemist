package it.unibo.alchemist.model.implementations.linkingrules;

import java.util.Objects;

import it.unibo.alchemist.model.interfaces.Molecule;
import it.unibo.alchemist.model.interfaces.Node;

/**
 * A {@link ClosestN} rule that also checks that a {@link Molecule} has a
 * specific concentration before allowing the connection.
 * 
 * @param <T>
 */
public class ConditionalClosestN<T> extends ClosestN<T> {

    private static final long serialVersionUID = 1L;
    private final Molecule molecule;
    private final T value;

    /**
     * @param n
     *            number of neighbors
     * @param expectedNodes
     *            expected number of nodes (used for optimization purposes)
     * @param mol
     *            the molecule whose concentration will be used to identify
     *            active nodes
     * @param value
     *            the value that identifies an active node
     */
    public ConditionalClosestN(final int n, final int expectedNodes, final Molecule mol, final T value) {
        super(n, expectedNodes);
        this.molecule = Objects.requireNonNull(mol);
        this.value = Objects.requireNonNull(value);
    }

    /**
     * @param n
     *            number of neighbors
     * @param mol
     *            the molecule whose concentration will be used to identify
     *            active nodes
     * @param value
     *            the value that identifies an active node
     */
    public ConditionalClosestN(final int n, final Molecule mol, final T value) {
        this(n,  0, mol, value);
    }

    @Override
    protected boolean nodeIsEnabled(final Node<T> node) {
        return value.equals(node.getConcentration(molecule));
    }

}
