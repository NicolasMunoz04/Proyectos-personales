/********************************************************************************
** Form generated from reading UI file 'NotePencil.ui'
**
** Created by: Qt User Interface Compiler version 6.8.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_NOTEPENCIL_H
#define UI_NOTEPENCIL_H

#include <QtCore/QVariant>
#include <QtGui/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenu>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPlainTextEdit>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_NotePencil
{
public:
    QAction *actionAbrir;
    QAction *actionGuardar;
    QAction *actionSalir;
    QAction *actionInformacion;
    QWidget *centralwidget;
    QPlainTextEdit *plainTextEdit;
    QStatusBar *statusbar;
    QMenuBar *menubar;
    QMenu *menuAbout_Us;
    QMenu *menuArchivo;

    void setupUi(QMainWindow *NotePencil)
    {
        if (NotePencil->objectName().isEmpty())
            NotePencil->setObjectName("NotePencil");
        NotePencil->resize(806, 369);
        actionAbrir = new QAction(NotePencil);
        actionAbrir->setObjectName("actionAbrir");
        QIcon icon;
        if (QIcon::hasThemeIcon(QIcon::ThemeIcon::DocumentOpen)) {
            icon = QIcon::fromTheme(QIcon::ThemeIcon::DocumentOpen);
        } else {
            icon.addFile(QString::fromUtf8("Icons/OpenFile.png"), QSize(), QIcon::Mode::Normal, QIcon::State::Off);
        }
        actionAbrir->setIcon(icon);
        actionGuardar = new QAction(NotePencil);
        actionGuardar->setObjectName("actionGuardar");
        QIcon icon1;
        if (QIcon::hasThemeIcon(QIcon::ThemeIcon::DocumentSave)) {
            icon1 = QIcon::fromTheme(QIcon::ThemeIcon::DocumentSave);
        } else {
            icon1.addFile(QString::fromUtf8("Icons/SaveFile.png"), QSize(), QIcon::Mode::Normal, QIcon::State::Off);
        }
        actionGuardar->setIcon(icon1);
        actionGuardar->setMenuRole(QAction::MenuRole::NoRole);
        actionSalir = new QAction(NotePencil);
        actionSalir->setObjectName("actionSalir");
        actionSalir->setCheckable(false);
        QIcon icon2;
        if (QIcon::hasThemeIcon(QIcon::ThemeIcon::SystemLogOut)) {
            icon2 = QIcon::fromTheme(QIcon::ThemeIcon::SystemLogOut);
        } else {
            icon2.addFile(QString::fromUtf8("Icons/Exit.png"), QSize(), QIcon::Mode::Normal, QIcon::State::Off);
        }
        actionSalir->setIcon(icon2);
        actionSalir->setMenuRole(QAction::MenuRole::NoRole);
        actionInformacion = new QAction(NotePencil);
        actionInformacion->setObjectName("actionInformacion");
        QIcon icon3;
        if (QIcon::hasThemeIcon(QIcon::ThemeIcon::InsertImage)) {
            icon3 = QIcon::fromTheme(QIcon::ThemeIcon::InsertImage);
        } else {
            icon3.addFile(QString::fromUtf8("Icons/Info.png"), QSize(), QIcon::Mode::Normal, QIcon::State::Off);
        }
        actionInformacion->setIcon(icon3);
        actionInformacion->setMenuRole(QAction::MenuRole::NoRole);
        centralwidget = new QWidget(NotePencil);
        centralwidget->setObjectName("centralwidget");
        plainTextEdit = new QPlainTextEdit(centralwidget);
        plainTextEdit->setObjectName("plainTextEdit");
        plainTextEdit->setGeometry(QRect(0, 0, 821, 561));
        NotePencil->setCentralWidget(centralwidget);
        statusbar = new QStatusBar(NotePencil);
        statusbar->setObjectName("statusbar");
        NotePencil->setStatusBar(statusbar);
        menubar = new QMenuBar(NotePencil);
        menubar->setObjectName("menubar");
        menubar->setGeometry(QRect(0, 0, 806, 21));
        menuAbout_Us = new QMenu(menubar);
        menuAbout_Us->setObjectName("menuAbout_Us");
        menuArchivo = new QMenu(menubar);
        menuArchivo->setObjectName("menuArchivo");
        NotePencil->setMenuBar(menubar);

        menubar->addAction(menuArchivo->menuAction());
        menubar->addAction(menuAbout_Us->menuAction());
        menuAbout_Us->addAction(actionInformacion);
        menuArchivo->addAction(actionAbrir);
        menuArchivo->addAction(actionGuardar);
        menuArchivo->addAction(actionSalir);

        retranslateUi(NotePencil);

        QMetaObject::connectSlotsByName(NotePencil);
    } // setupUi

    void retranslateUi(QMainWindow *NotePencil)
    {
        NotePencil->setWindowTitle(QCoreApplication::translate("NotePencil", "MainWindow", nullptr));
        actionAbrir->setText(QCoreApplication::translate("NotePencil", "Abrir...", nullptr));
#if QT_CONFIG(tooltip)
        actionAbrir->setToolTip(QCoreApplication::translate("NotePencil", "Abrir archivo existente.", nullptr));
#endif // QT_CONFIG(tooltip)
#if QT_CONFIG(shortcut)
        actionAbrir->setShortcut(QCoreApplication::translate("NotePencil", "Ctrl+O", nullptr));
#endif // QT_CONFIG(shortcut)
        actionGuardar->setText(QCoreApplication::translate("NotePencil", "Guardar", nullptr));
#if QT_CONFIG(tooltip)
        actionGuardar->setToolTip(QCoreApplication::translate("NotePencil", "Guardar archivo.", nullptr));
#endif // QT_CONFIG(tooltip)
#if QT_CONFIG(shortcut)
        actionGuardar->setShortcut(QCoreApplication::translate("NotePencil", "Ctrl+S", nullptr));
#endif // QT_CONFIG(shortcut)
        actionSalir->setText(QCoreApplication::translate("NotePencil", "Salir", nullptr));
        actionInformacion->setText(QCoreApplication::translate("NotePencil", "Informaci\303\263n", nullptr));
        menuAbout_Us->setTitle(QCoreApplication::translate("NotePencil", "About Us", nullptr));
        menuArchivo->setTitle(QCoreApplication::translate("NotePencil", "Archivo", nullptr));
    } // retranslateUi

};

namespace Ui {
    class NotePencil: public Ui_NotePencil {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_NOTEPENCIL_H
