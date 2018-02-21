package ren.mosto.resume.model;

/**
 * Created by ye on 2017/11/19.
 */
public interface ResumeOthers<T> extends HasResumeId<T> {

    public String getName() ;

    public void setName(String name) ;

    public String getDescription() ;

    public void setDescription(String description) ;

}
