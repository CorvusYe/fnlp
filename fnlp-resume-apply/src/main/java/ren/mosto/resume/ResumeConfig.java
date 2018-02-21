package ren.mosto.resume;

import ren.mosto.resume.handle.DocDefaultPreHandler;
import ren.mosto.resume.model.constant.ResolverConstant;
import lombok.extern.slf4j.Slf4j;
import ren.mosto.resume.model.*;

import java.util.*;

/**
 * 简历配置类，用于根据文本简历的实际情况，为简历动态创建对象
 * T 主键类型
 * Created by ye on 2017/11/19.
 */
@Slf4j
public class ResumeConfig<T> {

    private static Class<? extends Resume> resumeType = null;
    private static Class<? extends Position> positionType = null;
    private static Class<? extends ResumeAttachment> resumeAttachmentType = null;
    private static Class<? extends ResumeBase> resumeBaseType = null;
    private static Class<? extends ResumeCertificate> resumeCertificateType = null;
    private static Class<? extends ResumeEducationHistory> resumeEducationType = null;
    private static Class<? extends ResumeFamily> resumeFamilyType = null;
    private static Class<? extends ResumeIntention> resumeIntentionType = null;
    private static Class<? extends ResumeIntroducer> resumeIntroducerType = null;
    private static Class<? extends ResumeOthers> resumeOthersType = null;
    private static Class<? extends ResumePrize> resumePrizeType = null;
    private static Class<? extends ResumeProjectExperience> resumeProjectExperienceType = null;
    private static Class<? extends ResumeSchoolPost> resumeSchoolPostType = null;
    private static Class<? extends ResumeSkill> resumeSkillType = null;
    private static Class<? extends ResumeTrainHistory> resumeTrainHistoryType = null;
    private static Class<? extends ResumeWorkHistory> resumeWorkHistoryType = null;

    public static ResumeConfig cfg;

    public Resume newResume() {
        try {
            Resume resume;
            if( resumeType == null ) {
                resume = new ResumeBO<T>();
            } else {
                resume = resumeType.newInstance();
            }

            resume.setAttachment( new ArrayList<ResumeAttachment>() );
            if( resumeBaseType != null ) {
                resume.setBaseInfo( resumeBaseType.newInstance() );
            }
            resume.setCertificate(new ArrayList<ResumeCertificate>());
            resume.setEducation(new ArrayList<ResumeEducationHistory>());
            resume.setFamily(new ArrayList<ResumeFamily>());

            if( resumeIntentionType != null ) {
                resume.setIntention(resumeIntentionType.newInstance());
            }
            if(resumeIntroducerType != null ) {
                resume.setIntroducer(resumeIntroducerType.newInstance());
            }
            resume.setOthers(new ArrayList<ResumeOthers>());
            resume.setPrize(new ArrayList<ResumePrize>());
            resume.setProject(new ArrayList<ResumeProjectExperience>());
            resume.setSchoolPost(new ArrayList<ResumeSchoolPost>());
            resume.setSkill(new ArrayList<ResumeSkill>());
            resume.setTrain(new ArrayList<ResumeTrainHistory>());
            resume.setExperience(new ArrayList<ResumeWorkHistory>());

            return resume;
        } catch (InstantiationException e) {
            // e.printStackTrace();
        } catch (IllegalAccessException e) {
            // e.printStackTrace();
        }
        return null;
    }

    private final static Map<String, ResumeResolver> resolverMap = new HashMap<String, ResumeResolver>();

    private final static Map<String, Map<Integer, ResumePreHandler>> channelPreHandlerMap = new HashMap<>();

    private final static Set<ResumeSufHandler> sufHandlers = new HashSet<>();

    public ResumeConfig putSufHandler( ResumeSufHandler handler ) {
        sufHandlers.add( handler );
        return this;
    }

    public static Set<ResumeSufHandler> getSufHandlers() {
        return sufHandlers;
    }

    public ResumeConfig putPreHandler(String channel, int contentType, ResumePreHandler preHandler) {
        Map<Integer, ResumePreHandler> channelContentTypePreHandler = channelPreHandlerMap.get(channel);
        if( channelContentTypePreHandler == null ) {
            channelContentTypePreHandler = new HashMap<>();
            channelPreHandlerMap.put( channel, channelContentTypePreHandler );
        }
        channelContentTypePreHandler.put(contentType, preHandler);
        return this;
    }

    public ResumeConfig putResolver( String channel, ResumeResolver resolver ) {
        resolverMap.put( channel, resolver );
        return this;
    }

    public static ResumePreHandler getPreHandler(String channel, int contentType) {
        ResumePreHandler preHandler = channelPreHandlerMap.get( channel ).get(contentType);
        if( preHandler == null ) {
            if( contentType == ResolverConstant.CONTENT_TYPE_WORD ) {
                return new DocDefaultPreHandler();
            } else {
                log.warn( "Resume pre handler is null in content type : {}", contentType );
                return new ResumePreHandler() {
                    @Override
                    public String[] handle(Object content) {
                        return new String[]{content.toString()};
                    }
                };
            }
        }
        return preHandler;
    }

    public static ResumeResolver getResolver( String channel ) {
        return resolverMap.get( channel );
    }

    public void clearResolvers() {
        resolverMap.clear();
    }

    public ResumeConfig(
            Class<? extends Position> positionType,
            Class<? extends ResumeAttachment> resumeAttachmentType,
            Class<? extends ResumeBase> resumeBaseType,
            Class<? extends ResumeCertificate> resumeCertificateType,
            Class<? extends ResumeEducationHistory> resumeEducationType,
            Class<? extends ResumeFamily> resumeFamilyType,
            Class<? extends ResumeIntention> resumeIntentionType,
            Class<? extends ResumeIntroducer> resumeIntroducerType,
            Class<? extends ResumeOthers> resumeOthersType,
            Class<? extends ResumePrize> resumePrizeType,
            Class<? extends ResumeProjectExperience> resumeProjectExperienceType,
            Class<? extends ResumeSchoolPost> resumeSchoolPostType,
            Class<? extends ResumeSkill> resumeSkillType,
            Class<? extends ResumeTrainHistory> resumeTrainHistoryType,
            Class<? extends ResumeWorkHistory> resumeWorkHistoryType) {
        ResumeConfig.positionType = positionType;
        ResumeConfig.resumeAttachmentType = resumeAttachmentType;
        ResumeConfig.resumeBaseType = resumeBaseType;
        ResumeConfig.resumeCertificateType = resumeCertificateType;
        ResumeConfig.resumeEducationType = resumeEducationType;
        ResumeConfig.resumeFamilyType = resumeFamilyType;
        ResumeConfig.resumeIntentionType = resumeIntentionType;
        ResumeConfig.resumeIntroducerType = resumeIntroducerType;
        ResumeConfig.resumeOthersType = resumeOthersType;
        ResumeConfig.resumePrizeType = resumePrizeType;
        ResumeConfig.resumeProjectExperienceType = resumeProjectExperienceType;
        ResumeConfig.resumeSchoolPostType = resumeSchoolPostType;
        ResumeConfig.resumeSkillType = resumeSkillType;
        ResumeConfig.resumeTrainHistoryType = resumeTrainHistoryType;
        ResumeConfig.resumeWorkHistoryType = resumeWorkHistoryType;
        cfg = this;
    }

    public static Class<? extends Resume> getResumeType() {
        return resumeType;
    }

    public static void setResumeType(Class<? extends Resume> resumeType) {
        ResumeConfig.resumeType = resumeType;
    }

    public static Class<? extends Position> getPositionType() {
        return positionType;
    }

    public static void setPositionType(Class<? extends Position> positionType) {
        ResumeConfig.positionType = positionType;
    }

    public static Class<? extends ResumeAttachment> getResumeAttachmentType() {
        return resumeAttachmentType;
    }

    public static void setResumeAttachmentType(Class<? extends ResumeAttachment> resumeAttachmentType) {
        ResumeConfig.resumeAttachmentType = resumeAttachmentType;
    }

    public static Class<? extends ResumeBase> getResumeBaseType() {
        return resumeBaseType;
    }

    public static void setResumeBaseType(Class<? extends ResumeBase> resumeBaseType) {
        ResumeConfig.resumeBaseType = resumeBaseType;
    }

    public static Class<? extends ResumeCertificate> getResumeCertificateType() {
        return resumeCertificateType;
    }

    public static void setResumeCertificateType(Class<? extends ResumeCertificate> resumeCertificateType) {
        ResumeConfig.resumeCertificateType = resumeCertificateType;
    }

    public static Class<? extends ResumeEducationHistory> getResumeEducationType() {
        return resumeEducationType;
    }

    public static void setResumeEducationType(Class<? extends ResumeEducationHistory> resumeEducationType) {
        ResumeConfig.resumeEducationType = resumeEducationType;
    }

    public static Class<? extends ResumeFamily> getResumeFamilyType() {
        return resumeFamilyType;
    }

    public static void setResumeFamilyType(Class<? extends ResumeFamily> resumeFamilyType) {
        ResumeConfig.resumeFamilyType = resumeFamilyType;
    }

    public static Class<? extends ResumeIntention> getResumeIntentionType() {
        return resumeIntentionType;
    }

    public static void setResumeIntentionType(Class<? extends ResumeIntention> resumeIntentionType) {
        ResumeConfig.resumeIntentionType = resumeIntentionType;
    }

    public static Class<? extends ResumeIntroducer> getResumeIntroducerType() {
        return resumeIntroducerType;
    }

    public static void setResumeIntroducerType(Class<? extends ResumeIntroducer> resumeIntroducerType) {
        ResumeConfig.resumeIntroducerType = resumeIntroducerType;
    }

    public static Class<? extends ResumeOthers> getResumeOthersType() {
        return resumeOthersType;
    }

    public static void setResumeOthersType(Class<? extends ResumeOthers> resumeOthersType) {
        ResumeConfig.resumeOthersType = resumeOthersType;
    }

    public static Class<? extends ResumePrize> getResumePrizeType() {
        return resumePrizeType;
    }

    public static void setResumePrizeType(Class<? extends ResumePrize> resumePrizeType) {
        ResumeConfig.resumePrizeType = resumePrizeType;
    }

    public static Class<? extends ResumeProjectExperience> getResumeProjectExperienceType() {
        return resumeProjectExperienceType;
    }

    public static void setResumeProjectExperienceType(Class<? extends ResumeProjectExperience> resumeProjectExperienceType) {
        ResumeConfig.resumeProjectExperienceType = resumeProjectExperienceType;
    }

    public static Class<? extends ResumeSchoolPost> getResumeSchoolPostType() {
        return resumeSchoolPostType;
    }

    public static void setResumeSchoolPostType(Class<? extends ResumeSchoolPost> resumeSchoolPostType) {
        ResumeConfig.resumeSchoolPostType = resumeSchoolPostType;
    }

    public static Class<? extends ResumeSkill> getResumeSkillType() {
        return resumeSkillType;
    }

    public static void setResumeSkillType(Class<? extends ResumeSkill> resumeSkillType) {
        ResumeConfig.resumeSkillType = resumeSkillType;
    }

    public static Class<? extends ResumeTrainHistory> getResumeTrainHistoryType() {
        return resumeTrainHistoryType;
    }

    public static void setResumeTrainHistoryType(Class<? extends ResumeTrainHistory> resumeTrainHistoryType) {
        ResumeConfig.resumeTrainHistoryType = resumeTrainHistoryType;
    }

    public static Class<? extends ResumeWorkHistory> getResumeWorkHistoryType() {
        return resumeWorkHistoryType;
    }

    public static void setResumeWorkHistoryType(Class<? extends ResumeWorkHistory> resumeWorkHistoryType) {
        ResumeConfig.resumeWorkHistoryType = resumeWorkHistoryType;
    }

    public static Map<String, ResumeResolver> getResolverMap() {
        return resolverMap;
    }

}
