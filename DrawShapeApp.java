import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

///Interface to represent a shape
interface Shape {
    void paint(Graphics g);
}

/// Concrete class representing a circle shape
class Circle implements Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void paint(Graphics g) {
        // Set the color to blue
        g.setColor(Color.blue);

        // Draw a circle with center at (x,y) and r = radius
        g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);

    }
}

/// Conrete class representing a box shape
class Box implements Shape {
    private int x, y, width, height;

    public Box(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void paint(Graphics g) {
        // Set the color to blue
        g.setColor(Color.blue);

        /// Draw a rectangle
        g.drawRect(x, y, width, height);

    }
}

/// Expert interface for creating shapes
interface Expert {
    Shape creatShape(int x, int y, int size);

}

/// Concrete expert class for creating circles
class CircleExpert implements Expert {
    @Override
    public Shape creatShape(int x, int y, int size) {
        return new Circle(x, y, size);
    }
}

/// Concrete expert class for creating boxes
class BoxExpert implements Expert {
    @Override
    public Shape creatShape(int x, int y, int size) {
        return new Box(x, y, size, size);
    }
}

/// Collection of Shapes (composite)
class CollectionOfShapes implements Shape {
    private List<Shape> shapesList = new ArrayList<>();

    /// Add shapes to the collection
    public void addShape(Shape shape) {
        shapesList.add(shape);
    }

    /// Iterator implementation
    @Override
    public void paint(Graphics g) {
        Iterator<Shape> it = shapesList.iterator();
        while (it.hasNext()) {
            it.next().paint(g);
        }

    }
}

/// Controller class responsible for handling shape-related actions
class DrawShapeController {
    private String selectedShapeType;
    private CollectionOfShapes shapes;

    public DrawShapeController(CollectionOfShapes shapes) {
        this.shapes = shapes;
    }

    /// Set the selected shape type
    public void setSelectedShapeType(String shapeType) {
        this.selectedShapeType = shapeType;
    }

    /// Handle mouse click on the canvas. This method creates shapes and adds it to
    /// the list.
    public void handleCanvasClick(int x, int y) {
        /// Delegate the task to create shapes to the appropriate experts.
        Expert expert;

        if (selectedShapeType.equals("Circles")) {
            expert = new CircleExpert();
        } else if (selectedShapeType.equals("Boxes")) {
            expert = new BoxExpert();
        } else {
            throw new IllegalArgumentException("Invalid shape type");
        }

        /// Create the shape using the expert and add it to the list
        shapes.addShape(expert.creatShape(x, y, 30));

    }

}

/// Canvas class to display shapes
class Canvas extends JPanel {
    private CollectionOfShapes collectionOfShapes;
    private DrawShapeController controller;

    public Canvas(CollectionOfShapes collectionOfShapes, DrawShapeController controller) {
        this.collectionOfShapes = collectionOfShapes;
        this.controller = controller;
        setupMouseListener();
    }

    private void setupMouseListener() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /// When canvas is clicked, add a shape (either circle or box)
                /// e.getX() and e.getY() gives the x-coordinate and y-coordinate of the mouse
                /// click relative to the source component (Canvas).
                controller.handleCanvasClick(e.getX(), e.getY());
                repaint(); /// This method in Swing triggers call to paintComponent method.
            }
        });

    }

    /// Overriding the default paintComponent method from JPanel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        /// Customize paint
        collectionOfShapes.paint(g);

    }
}

public class DrawShapeApp {
    public static void main(String[] args) {
        /// Using this utility function for thread-safe allowing components to be
        /// synchronized while updating the GUI. It helps to avoid freezing or lagging
        /// the GUI.
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Shape Drawer App");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            CollectionOfShapes shapes = new CollectionOfShapes();
            DrawShapeController controller = new DrawShapeController(shapes);
            Canvas canvas = new Canvas(shapes, controller);

            JButton circleButton = new JButton("Circle");
            JButton boxButton = new JButton("Boxes");

            circleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /// Set the selected shape type to "Circles"
                    controller.setSelectedShapeType("Circles");
                }
            });

            boxButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /// Set the selected shape type to "Circles"
                    controller.setSelectedShapeType("Boxes");
                }
            });

            ///// Creating buttons panel
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(circleButton);
            buttonPanel.add(boxButton);
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
            buttonPanel.setBackground(Color.white);
            buttonPanel.setSize(300, 600);
            /// Adding margin top - not needed but complements GUI.
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

            /// Adding components to the frame.
            frame.setLayout(new BorderLayout());
            frame.add(buttonPanel, BorderLayout.WEST);
            frame.add(canvas, BorderLayout.CENTER);

            frame.setVisible(true);

        });
    }
}
