package TestRajaa;

/**
 * Created by initial on 17/05/2017.
 */
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class f extends Application {

    @Override
    public void start(Stage primaryStage) {
        final Pane root = new Pane();
        Image imgA = new Image("file:data/imgPerso/images/heureux.jpg");
        final ImageView imageView = new ImageView(imgA);
        final Circle clip = new Circle(300, 200, 200);
        imageView.setClip(clip);
        root.getChildren().add(imageView);

        // enable dragging:
        final ObjectProperty<Point2D> mouseAnchor = new SimpleObjectProperty<>();
        imageView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mouseAnchor.set(new Point2D(event.getSceneX(), event.getSceneY()));
            }
        });
        imageView.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double deltaX = event.getSceneX() - mouseAnchor.get().getX();
                double deltaY = event.getSceneY() - mouseAnchor.get().getY();
                imageView.setLayoutX(imageView.getLayoutX() + deltaX);
                imageView.setLayoutY(imageView.getLayoutY() + deltaY);
                clip.setCenterX(clip.getCenterX() - deltaX);
                clip.setCenterY(clip.getCenterY() - deltaY);
                mouseAnchor.set(new Point2D(event.getSceneX(), event.getSceneY()));
            }
        });

        final Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
