/**
 * Testet die Aktualisierung von Statusvariablen.
 */
import { expect, test } from "vitest";

test("updates state variables", () => {
  // Arrange
  let name = "";
  let message = "";
  let status = "";

  /**
   * Aktualisiert den Zustand der Variablen.
   * @param {Object} newState - Das neue Zustandsobjekt.
   * @param {string} newState.name - Der neue Name.
   * @param {string} newState.message - Die neue Nachricht.
   * @param {string} newState.status - Der neue Status.
   */
  const setState = (newState) => {
    name = newState.name !== undefined ? newState.name : name;
    message = newState.message !== undefined ? newState.message : message;
    status = newState.status !== undefined ? newState.status : status;
  };

  // Act
  setState({
    name: "John",
    message: "Hello, World!",
    status: "success",
  });

  // Assert
  expect(name).toBe("John");
  expect(message).toBe("Hello, World!");
  expect(status).toBe("success");
});

