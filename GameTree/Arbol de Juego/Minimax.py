import random
import math

class TaTeTi:
    def __init__(self):
        self.board = ["-" for _ in range(9)]
        if random.randint(0, 1) == 1:
            self.jugadorHumano = "X"
            self.jugadorBot = "O"
        else:
            self.jugadorHumano = "O"
            self.jugadorBot = "X"
    
    def mostrar_tablero(self):
        print("")
        for i in range(3):
            print(" ", self.board[0+(i*3)], " | ", self.board[1+(i*3)], "|", self.board[2+(i*3)])
            if i < 2:
                print("---------------")
        print("")
    
    def tablero_lleno(self, state):
        return "-" not in state
    
    def jugador_ganador(self, state, jugador):
        combinaciones_ganadoras = [
            [0, 1, 2], [3, 4, 5], [6, 7, 8], 
            [0, 3, 6], [1, 4, 7], [2, 5, 8], 
            [0, 4, 8], [2, 4, 6]
        ]
        for combo in combinaciones_ganadoras:
            if all(state[i] == jugador for i in combo):
                return True
        return False
    
    def chequear_ganador(self):
        if self.jugador_ganador(self.board, self.jugadorHumano):
            print(f"  El jugador {self.jugadorHumano} es el ganador!")
            return True
        if self.jugador_ganador(self.board, self.jugadorBot):
            print(f"  El jugador {self.jugadorBot} es el ganador!")
            return True
        if self.tablero_lleno(self.board):
            print("  ¡Empate!")
            return True
        return False
    
    def start(self):
        bot = ComputerPlayer(self.jugadorBot)
        humano = JugadorHumano(self.jugadorHumano)
        juego_activo = True
        while juego_activo:
            print(f"  Turno de {self.jugadorHumano}")
            self.mostrar_tablero()

            # Turno del jugador humano
            square = humano.movimiento_humano(self.board)
            self.board[square] = self.jugadorHumano
            juego_activo = not self.chequear_ganador()

            if juego_activo:
                # Turno del bot
                square = bot.mov_maquina(self.board)
                self.board[square] = self.jugadorBot
                juego_activo = not self.chequear_ganador()
        
        # Mostrar el tablero final
        print()
        self.mostrar_tablero()

class JugadorHumano:
    def __init__(self, letra):
        self.letra = letra
    
    def movimiento_humano(self, state):
        while True:
            try:
                square = int(input("Ingrese el lugar para colocar su letra (1-9): ")) - 1
                if 0 <= square <= 8 and state[square] == "-":
                    return square
                else:
                    print("Movimiento inválido. Intente de nuevo.")
            except ValueError:
                print("Por favor ingrese un número válido.")

class ComputerPlayer:
    def __init__(self, letra):
        self.jugadorBot = letra
        self.jugadorHumano = "X" if letra == "O" else "O"
    
    def acciones(self, state):
        return [i for i, x in enumerate(state) if x == "-"]

    def resultado(self, state, accion, jugador):
        newState = state.copy()
        newState[accion] = jugador
        return newState
    
    def terminal(self, state):
        return TaTeTi().jugador_ganador(state, "X") or TaTeTi().jugador_ganador(state, "O") or TaTeTi().tablero_lleno(state)
    
    def minimax(self, state, jugador):
        max_jugador = self.jugadorBot
        otro_jugador = "O" if jugador == "X" else "X"

        if self.terminal(state):
            if TaTeTi().jugador_ganador(state, max_jugador):
                return {"posicion": None, "puntos": 1}
            elif TaTeTi().jugador_ganador(state, otro_jugador):
                return {"posicion": None, "puntos": -1}
            else:
                return {"posicion": None, "puntos": 0}
        
        if jugador == max_jugador:
            best = {"posicion": None, "puntos": -math.inf}
        else:
            best = {"posicion": None, "puntos": math.inf}
        
        for posible_movimiento in self.acciones(state):
            newState = self.resultado(state, posible_movimiento, jugador)
            sim_score = self.minimax(newState, otro_jugador)
            sim_score["posicion"] = posible_movimiento

            if jugador == max_jugador:
                if sim_score["puntos"] > best["puntos"]:
                    best = sim_score
            else:
                if sim_score["puntos"] < best["puntos"]:
                    best = sim_score
        
        return best
    
    def mov_maquina(self, state):
        square = self.minimax(state, self.jugadorBot)["posicion"]
        return square

# Empezar el juego
if __name__ == "__main__":
    TaTeTi().start()

