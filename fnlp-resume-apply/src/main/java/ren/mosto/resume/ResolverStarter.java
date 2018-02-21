package ren.mosto.resume;

import ren.mosto.resume.exception.ChannelNullException;
import ren.mosto.resume.exception.ResolverNotFoundException;
import ren.mosto.resume.exception.ResumeContentNullException;
import ren.mosto.resume.model.Resume;
import ren.mosto.resume.feature.Feature;
import ren.mosto.resume.model.constant.ResolverConstant;
import ren.mosto.resume.utils.XdfPropertiesUtil;

import java.util.LinkedHashSet;
import java.util.Set;


/**
 * 类描述：解析命令入口
 * 应用方法：
 * <li>通过 ResumeConfig cfg = new ResumeConfig( .... ) 的方式，对多个简历实体实现类进行配置
 * <li>通过 {@link ResumeConfig#putPreHandler} 方法，传入各渠道不同的预处理器与解析器<br>
 *          如无需传入预处理器，可直接调用 {@link ResumeConfig#putResolver} 方法，对不同渠道的解析器进行处理
 * @author yeweicheng@xdf.cn
 *
 */
public class ResolverStarter {

    private final static Set<Feature> defaultFeatureList = new LinkedHashSet<>();

    static {
        defaultFeatureList.add( Feature.NAME );
        defaultFeatureList.add( Feature.SEX );
    }

    /**
     * 解析器入口方法。总控简历解析逻辑。
     * <li>获取预处理器，将不同形式的入参转换成纯文本类型</li>
     * <li>获取解析器，将纯文本类型数据解析成 {@link ren.mosto.resume.model.Resume } </li>
     * @param content 包含简历信息的文本
     * @param channel 简历来源（渠道），
     *                <li>以便从 {@link ResumeConfig#resolverMap} 中获取相对应的解析器
     *                <li>同时从 {@link ResumeConfig#channelPreHandlerMap} 中获取相对应的预处理器
     * @return 返回简历对象
     */
    public static Resume resolve( Object content, String channel, int contentType  ) {
        // 对参数进行熔断处理
        if( XdfPropertiesUtil.isNull(content) ) {
            throw new ResumeContentNullException();
        }
        if( XdfPropertiesUtil.isNull(channel) ) {
            throw new ChannelNullException();
        }

        // 对文本进行预处理
        ResumePreHandler preHandler = ResumeConfig.getPreHandler(channel, contentType);
        String[] contentText = preHandler.handle( content );

        // 将纯文本传入解析器
        ResumeResolver resolver = ResumeConfig.getResolver(channel);
        if( resolver == null ) {
            throw new ResolverNotFoundException( channel );
        }

        // 对解析后的简历进行处理
        Resume resume = resolver.resolve(contentType, contentText);
        Set<ResumeSufHandler> sufHandlers = ResumeConfig.getSufHandlers();
        for( ResumeSufHandler sufHandler : sufHandlers ) {
            sufHandler.handle( resume, channel );
        }
        return resume;
    }

    public static Resume resolve( Object content, String channel ) {
        return resolve( content, channel, ResolverConstant.CONTENT_TYPE_HTML );
    }

}
