package ren.mosto.resume;

/**
 * Created by ye on 2017/11/19.
 */
public interface ResumePreHandler<T> {

    String[] handle(T content);

}
