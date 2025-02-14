#include "NotePencil.h"
#include "./ui_NotePencil.h"
#include <QFileDialog>
#include <QMessageBox>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::NotePencil)
{
    ui->setupUi(this);
    // Conecta la acción 'Información' al método 'mostrarInformacion'
    connect(ui->actionInformacion, &QAction::triggered, this, &MainWindow::mostrarInformacion);
}

MainWindow::~MainWindow()
{
    delete ui;
}

// Implementación de las acciones
void MainWindow::on_actionAbrir_triggered()
{
    // Abrir un cuadro de diálogo para seleccionar el archivo
    QString fileName = QFileDialog::getOpenFileName(this, "Abrir archivo", "", "Archivos de texto (*.txt);;Todos los archivos (*.*)");

    if (!fileName.isEmpty()) {
        QFile file(fileName); // Crear un objeto QFile
        if (!file.open(QIODevice::ReadOnly | QIODevice::Text)) {
            QMessageBox::warning(this, "Error", "No se pudo abrir el archivo.");
            return;
        }

        // Leer el contenido del archivo
        QTextStream in(&file);
        QString content = in.readAll();
        file.close();

        // Mostrar el contenido en el área de texto
        ui->plainTextEdit->setPlainText(content); // plainTextEdit es el nombre del widget
    }

}

void MainWindow::on_actionGuardar_triggered()
{
    // Abrir un cuadro de diálogo para seleccionar el nombre y ubicación del archivo
    QString fileName = QFileDialog::getSaveFileName(this, "Guardar archivo", "", "Archivos de texto (*.txt);;Todos los archivos (*.*)");

    if (!fileName.isEmpty()) {
        QFile file(fileName); // Crear un objeto QFile
        if (!file.open(QIODevice::WriteOnly | QIODevice::Text)) {
            QMessageBox::warning(this, "Error", "No se pudo guardar el archivo.");
            return;
        }

        // Escribir el contenido del área de texto en el archivo
        QTextStream out(&file);
        QString content = ui->plainTextEdit->toPlainText(); // Obtener el texto del área de texto
        out << content;
        file.close();

        QMessageBox::information(this, "Guardar archivo", "El archivo se ha guardado correctamente.");
    }
}

void MainWindow::on_actionSalir_triggered()
{
    close(); // Cierra la aplicación
}


void MainWindow::mostrarInformacion()
{
    QMessageBox::information(this, "Acerca de",
                             "Desarrollado por Nicolas Muñoz\n"
                             "Analista Programador Universitario.");
}

