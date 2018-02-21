package ren.mosto.resume.exception;

/**
 * Created by ye on 2017/11/19.
 */
public class ResolverNotFoundException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param channel the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ResolverNotFoundException(String channel) {
        super( "Your have not config you resolver in ResumeConfig for channel " + channel);
    }
}
