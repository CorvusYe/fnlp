package ren.mosto.resume.model;

/**
 * Created by ye on 2017/11/19.
 */
public interface ResumeAttachment<T> extends HasResumeId<T> {

   String getName() ;

   void setName(String name) ;

   String getFileUrl() ;

   void setFileUrl(String fileUrl) ;

}
