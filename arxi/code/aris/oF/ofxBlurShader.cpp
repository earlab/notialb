#include "ofxBlurShader.h"

void ofxBlurShader::setup(int width, int height) {
	ping.allocate(width, height);
	pong.allocate(width, height);
	horizontalBlur.load("shaders/horizontalBlur");
	verticalBlur.load("shaders/verticalBlur");
}

void ofxBlurShader::setPasses(int passes) {
	this->passes = passes;
}

void ofxBlurShader::setRadius(float radius) {
	this->radius = radius;
}

void ofxBlurShader::begin() {
	ofPushStyle();
	ofPushMatrix();
	pong.begin();
}

void ofxBlurShader::end(bool draw) {
	pong.end();
	
	glColor4f(1, 1, 1, 1);
	for(int i = 0; i < passes; i++) {	
		ping.begin();
		horizontalBlur.begin();
		horizontalBlur.setUniform1f("radius", radius);
		pong.draw(0, 0);
		horizontalBlur.end();
		ping.end();
		
		pong.begin();
		verticalBlur.begin();
		verticalBlur.setUniform1f("radius", radius);
		ping.draw(0, 0);
		verticalBlur.end();
		pong.end();
	}
	
	if(draw) {
		pong.draw(0, 0);
	}
	
	ofPopStyle();
	ofPopMatrix();
}

ofTexture& ofxBlurShader::getTextureReference() {
	return pong.getTextureReference(0);
}
