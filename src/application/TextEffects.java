package application;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class TextEffects {
	
	public Text fadeInAndOut(Text textToApply, double upperIntensity, double lowerIntensity, int duration){
		
		FadeTransition ft = new FadeTransition(Duration.millis(duration), textToApply);
		ft.setFromValue(upperIntensity);
		ft.setToValue(lowerIntensity);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();
		return textToApply;
	}
}
