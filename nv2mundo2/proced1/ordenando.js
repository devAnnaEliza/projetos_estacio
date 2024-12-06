function swap(arr, posicao1, posicao2) {
  const temp = arr[posicao1];
  arr[posicao1] = arr[posicao2];
  arr[posicao2] = temp;
}

function shuffle(arr, swaps) {
  for (let i = 0; i < swaps; i++) {
    const pos1 = Math.floor(Math.random() * arr.length);
    const pos2 = Math.floor(Math.random() * arr.length);
    swap(arr, pos1, pos2);
  }
}

function bubbleSort(arr) {
  const n = arr.length;
  for (let i = 0; i < n - 1; i++) {
    for (let j = 0; j < n - i - 1; j++) {
      if (arr[j] > arr[j + 1]) {
        swap(arr, j, j + 1);
      }
    }
  }
}

function selectionSort(arr) {
  const n = arr.length;
  for (let i = 0; i < n - 1; i++) {
    let minIndex = i;
    for (let j = i + 1; j < n; j++) {
      if (arr[j] < arr[minIndex]) {
        minIndex = j;
      }
    }
    if (minIndex !== i) {
      swap(arr, i, minIndex);
    }
  }
}

function quickSort(arr, left, right) {
  if (left < right) {
    const pivotIndex = partition(arr, left, right);
    quickSort(arr, left, pivotIndex - 1);
    quickSort(arr, pivotIndex + 1, right);
  }
}

function partition(arr, left, right) {
  const pivot = arr[right];
  let i = left - 1;
  for (let j = left; j < right; j++) {
    if (arr[j] <= pivot) {
      i++;
      swap(arr, i, j);
    }
  }
  swap(arr, i + 1, right);
  return i + 1;
}

function add() {
  const valorInput = document.getElementById("valor");
  const valor = Number(valorInput.value);
  if (valor) {
    const li = document.createElement("li");
    li.textContent = valor;
    li.classList.add("valor");
    document.getElementById("valores").appendChild(li);
    valorInput.value = "";
  }
}

function limpar() {
  document.getElementById("valores").innerHTML = "";
}

function ordenar() {
  const lista = document.getElementById("valores");
  const vetor = Array.from(lista.children).map(item => parseInt(item.textContent));
  const algoritmo = document.getElementById("selecao").value;
  switch (algoritmo) {
    case "0":
      bubbleSort(vetor);
      break;
    case "1":
      selectionSort(vetor);
      break;
    case "2":
      quickSort(vetor, 0, vetor.length - 1);
      break;
  }
  const novosItens = vetor.map(item => `<li>${item}</li>`).join("");
  lista.innerHTML = novosItens;
}

function misturar() {
  const lista = document.getElementById("valores");
  const vetor = Array.from(lista.children).map(item => parseInt(item.textContent));
  shuffle(vetor, 10);
  const novosItens = vetor.map(item => `<li>${item}</li>`).join("");
  lista.innerHTML = novosItens;
}

function handleKeyDown(event) {
  if (event.key === "Enter") {
    add();
  }
}
