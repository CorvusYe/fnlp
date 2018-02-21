package ren.mosto.resume.exception;

/**
 * Created by ye on 2017/11/30.
 */
public class ChannelNullException extends RuntimeException {
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public ChannelNullException() {
        super( "Channel is null, please check your channel !" );
    }

}
