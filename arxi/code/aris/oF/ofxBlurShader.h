#pragma once

#include "ofGraphics.h"
#include "ofFbo.h"
#include "ofShader.h"

class ofxBlurShader {
public:
	void setup(int width, int height);
	void setPasses(int passes);
	void setRadius(float radius);
	void begin();
	void end(bool draw = true);
	ofTexture& getTextureReference();
	
private:
	ofFbo ping, pong;
	ofShader horizontalBlur, verticalBlur;
	int passes;
	float radius;
};