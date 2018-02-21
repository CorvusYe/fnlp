package ren.mosto.resume.feature;

/**
 * Created by ye on 2018/2/21.
 */
public enum Feature {

    NAME("name","baseInfo.name", FeatureType.ONE ),
    SEX("sex","baseInfo.sex", FeatureType.ONE );

    String featureName;

    String modelName;

    FeatureType featureType;

    Feature(String featureName, String modelName, FeatureType featureType) {
        this.featureName = featureName;
        this.modelName = modelName;
        this.featureType = featureType;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }
}
