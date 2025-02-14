#ifndef NOTEPENCIL_H
#define NOTEPENCIL_H

#include <QMainWindow>

QT_BEGIN_NAMESPACE
namespace Ui {
class NotePencil;
}
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    MainWindow(QWidget *parent = nullptr);
    ~MainWindow();

private slots:
    void on_actionAbrir_triggered();
    void on_actionGuardar_triggered();
    void on_actionSalir_triggered();
    void mostrarInformacion();

private:
    Ui::NotePencil *ui;
};
#endif // NOTEPENCIL_H
