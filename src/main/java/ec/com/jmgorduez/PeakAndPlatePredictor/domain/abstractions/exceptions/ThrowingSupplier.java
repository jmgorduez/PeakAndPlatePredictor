package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.exceptions;

import java.util.function.Supplier;

@FunctionalInterface
public interface ThrowingSupplier<R, E extends Throwable> {
    R get() throws E;
    static <R, E extends Throwable> Supplier<R> unchecked(ThrowingSupplier<R, E> f) {
        return () -> {
            try {
                return f.get();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }
}