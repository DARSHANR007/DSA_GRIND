func minWindow(s string, t string) string {

	if len(s) < len(t) {
		return ""
	}

	// Required frequencies
	need := make(map[byte]int)
	for i := 0; i < len(t); i++ {
		need[t[i]]++
	}

	// Current window frequencies
	window := make(map[byte]int)

	left := 0
	formed := 0                 // total matched characters
	required := len(t)          // total required characters

	minLen := int(1e9)
	start := 0

	for right := 0; right < len(s); right++ {

		c := s[right]

		// ALWAYS add to window
		window[c]++

		// Increase formed ONLY if this char was still needed
		if need[c] > 0 && window[c] <= need[c] {
			formed++
		}

		// Shrink only when fully formed
		for formed == required {

			if right-left+1 < minLen {
				minLen = right - left + 1
				start = left
			}

			leftChar := s[left]
			window[leftChar]--

			// If removal breaks requirement, reduce formed
			if need[leftChar] > 0 && window[leftChar] < need[leftChar] {
				formed--
			}

			left++
		}
	}

	if minLen == int(1e9) {
		return ""
	}

	return s[start : start+minLen]
}
