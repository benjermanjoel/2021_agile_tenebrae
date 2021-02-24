<script type="text/javascript">
  function rollDice() {
    let results = 0;
    let roll;

    let numDice = parseInt(document.getElementById('numDice').value, 10);
    let sides = parseInt(document.getElementById('sides').value, 10);

      for(let i = 0; i < numDice; i++){
        roll = (Math.ceil(Math.random() * sides));

        alert("Roll: " + roll);
        results += roll;
    }

    document.getElementById("results").innerHTML = results;
  }

</script>

<label for="sides">What kind of dice?</label>
<select id="sides" class="sides" name="sides">
  <option value="4">d4</option>
  <option value="6">d6</option>
  <option value="8">d8</option>
  <option value="10">d10</option>
  <option value="12">d12</option>
  <option value="20">d20</option>
  <option value="100">d100</option>
</select>

<label for="numDice">How many dice?</label>
<input type="text" name="numDice" id="numDice">
<button onclick="rollDice()" name="Dice Roll">Roll Dice</button>
<p id="results"></p>